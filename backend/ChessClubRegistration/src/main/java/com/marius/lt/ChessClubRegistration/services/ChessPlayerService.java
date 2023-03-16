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

    public ChessPlayer getChessPlayerByPin(Long pin){
        return this.chessPlayerRepository.findByPin(pin);
    }

    public void editItemById(ChessPlayer oldChessPlayer, ChessPlayer newChessPlayer) {

        if (newChessPlayer.getPin() != null && !oldChessPlayer.getPin().equals(newChessPlayer.getPin())) {
            oldChessPlayer.setPin(newChessPlayer.getPin());
        }
        if (newChessPlayer.getName() != null && !oldChessPlayer.getName().equals(newChessPlayer.getName())) {
            oldChessPlayer.setName(newChessPlayer.getName());
        }
        if (newChessPlayer.getLastname() != null && !oldChessPlayer.getLastname().equals(newChessPlayer.getLastname())) {
            oldChessPlayer.setLastname(newChessPlayer.getLastname());
        }
        if (newChessPlayer.getEmail() != null && !oldChessPlayer.getEmail().equals(newChessPlayer.getEmail())) {
            oldChessPlayer.setEmail(newChessPlayer.getEmail());
        }
        if (newChessPlayer.getStartedPlaying() != null && !oldChessPlayer.getStartedPlaying().equals(newChessPlayer.getStartedPlaying())) {
            oldChessPlayer.setStartedPlaying(newChessPlayer.getStartedPlaying());
        }
        this.chessPlayerRepository.saveAndFlush(oldChessPlayer);
    }

    public void saveChessPlayer(ChessPlayer chessPlayer) {
        this.chessPlayerRepository.saveAndFlush(chessPlayer);
    }

    public ChessPlayer getChessPlayerByEmail(String playerEmail) {
        return this.chessPlayerRepository.findByEmail(playerEmail);
    }
}
