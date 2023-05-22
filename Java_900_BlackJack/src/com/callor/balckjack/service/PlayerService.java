package com.callor.balckjack.service;

import com.callor.balckjack.models.CardDto;

public interface PlayerService {

	public void hit(CardDto card);

	public void showDeck();

	public int getScore();
	
	public String getPlayerName();
}
