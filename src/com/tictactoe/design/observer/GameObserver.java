package com.tictactoe.design.observer;

import com.tictactoe.design.*;

public interface GameObserver {
    void onGameEnd(GameState state, Player winner);


}
