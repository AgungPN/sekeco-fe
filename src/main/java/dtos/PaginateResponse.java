/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

public class PaginateResponse {
    protected int totalElements;
    public int totalPages;
    protected int size;
    protected int number;
    protected int numberOfElements;
    protected boolean first;
    protected boolean last;
    protected boolean empty;
    // NOTE:  private List<T> content; add this in inherits
}
