package com.marius.lt.ChessClubRegistration.services;

import com.marius.lt.ChessClubRegistration.entities.ChessPlayer;
import com.marius.lt.ChessClubRegistration.repositories.ChessPlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ChessPlayerService {

    private final ChessPlayerRepository chessPlayerRepository;

    public List<ChessPlayer> getAllChessPlayers() {
        return this.chessPlayerRepository.findAll();
    }

    public void deleteItemById(Long id) {
        this.chessPlayerRepository.deleteById(id);
    }

    public ChessPlayer getChessPlayerById(Long id) {
        Optional<ChessPlayer> optionalChessPlayer = this.chessPlayerRepository.findById(id);
        return optionalChessPlayer.orElse(null);
    }

    public void editItemById(Long id, ChessPlayer chessPlayer) {
        Optional<ChessPlayer> oldOptionalChessPlayer = this.chessPlayerRepository.findById(id);
        if (oldOptionalChessPlayer.isEmpty()) {
            return;
        }
        ChessPlayer oldChessPlayer = oldOptionalChessPlayer.get();

        if (chessPlayer.getPin() != null && !oldChessPlayer.getPin().equals(chessPlayer.getPin())) {
            oldChessPlayer.setPin(chessPlayer.getPin());
        }
        if (chessPlayer.getName() != null && !oldChessPlayer.getName().equals(chessPlayer.getName())) {
            oldChessPlayer.setName(chessPlayer.getName());
        }
        if (chessPlayer.getLastname() != null && !oldChessPlayer.getLastname().equals(chessPlayer.getLastname())) {
            oldChessPlayer.setLastname(chessPlayer.getLastname());
        }
        if (chessPlayer.getEmail() != null && !oldChessPlayer.getEmail().equals(chessPlayer.getEmail())) {
            oldChessPlayer.setEmail(chessPlayer.getEmail());
        }
        if (chessPlayer.getStartedPlaying() != null && !oldChessPlayer.getStartedPlaying().equals(chessPlayer.getStartedPlaying())) {
            oldChessPlayer.setStartedPlaying(chessPlayer.getStartedPlaying());
        }
        this.chessPlayerRepository.saveAndFlush(oldChessPlayer);
    }

    public void saveChessPlayer(ChessPlayer chessPlayer) {
        this.chessPlayerRepository.saveAndFlush(chessPlayer);
    }
}
