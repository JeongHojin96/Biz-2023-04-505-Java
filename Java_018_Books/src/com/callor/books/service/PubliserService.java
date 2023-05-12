package com.callor.books.service;

import java.util.List;

import com.callor.books.models.PubliserDto;

public interface PubliserService {

	public void loadPubliser();
	public void printPubliserList();
	public PubliserDto getPubliser(String Code);
	public List<PubliserDto> getPubliserList();
	public PubliserDto getPubliserListByName(String name);
	
}
