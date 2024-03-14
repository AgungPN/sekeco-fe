package dtos;

import lombok.Data;

import java.util.List;

public class PaginateResponse{
    protected int totalElements;
    protected int totalPages;
    protected int size;
    protected int number;
    protected int numberOfElements;
    protected boolean first;
    protected boolean last;
    protected boolean empty;
    // NOTE:  private List<T> content; add this in inherits
}
