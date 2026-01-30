package com.example.libraryapp.client.response;

import com.example.libraryapp.client.dto.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GoogleBookResponse {
    private List<Item> items;
}
