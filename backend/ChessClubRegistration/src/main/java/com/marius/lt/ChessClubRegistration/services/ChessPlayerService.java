package com.marius.lt.ChessClubRegistration.services;

import com.marius.lt.ChessClubRegistration.entities.ChessPlayer;
import com.marius.lt.ChessClubRegistration.repositories.ChessPlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChessPlayerService {

    private final ChessPlayerRepository chessPlayerRepository;

    public List<ChessPlayer> getAllChessPlayers() {
        return this.chessPlayerRepository.findAll();
    }
}
