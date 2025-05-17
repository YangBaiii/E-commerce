package com.ecommerce.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PageUtils {
    public static Pageable createPageable(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        String sortField = switch (sortBy.toLowerCase()) {
            case "id" -> "categoryId";
            case "name" -> "categoryName";
            default -> sortBy;
        };

        Sort sort = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        return PageRequest.of(pageNumber, pageSize, sort);
    }

    public static <T, R> void setPageResponse(Page<T> page, List<R> content, Object response) {
        try {
            response.getClass().getMethod("setContent", List.class).invoke(response, content);
            response.getClass().getMethod("setPageNumber", Integer.class).invoke(response, page.getNumber());
            response.getClass().getMethod("setPageSize", Integer.class).invoke(response, page.getSize());
            response.getClass().getMethod("setTotalElements", Long.class).invoke(response, page.getTotalElements());
            response.getClass().getMethod("setTotalPages", Long.class).invoke(response, (long) page.getTotalPages());
            response.getClass().getMethod("setLastPage", boolean.class).invoke(response, page.isLast());
        } catch (Exception e) {
            throw new RuntimeException("Error setting page response", e);
        }
    }
} 