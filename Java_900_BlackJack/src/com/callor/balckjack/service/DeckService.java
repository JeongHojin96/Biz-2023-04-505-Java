package com.callor.balckjack.service;

import java.util.List;

import com.callor.balckjack.models.CardDto;

public interface DeckService {

	public List<CardDto> newCardDeck();

	public CardDto getDeck();

	public void makeDeckList();

}
