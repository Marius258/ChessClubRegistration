package com.marius.lt.ChessClubRegistration.controllers;

import com.marius.lt.ChessClubRegistration.converters.ChessPlayerConverter;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerDTO;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerEditDTO;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerPayloadDTO;
import com.marius.lt.ChessClubRegistration.entities.ChessPlayer;
import com.marius.lt.ChessClubRegistration.exceptions.ErrorDetails;
import com.marius.lt.ChessClubRegistration.services.ChessPlayerService;
import jakarta.persistence.NoResultException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/chess_player")
public class ChessPlayerController {

    @Autowired
    public ChessPlayerService chessPlayerService;

    @GetMapping
    List<ChessPlayerDTO> getAllChessPlayers() {
        List<ChessPlayer> chessPlayerList = this.chessPlayerService.getAllChessPlayers();
        if (chessPlayerList.isEmpty()) {
            throw new NoResultException("There are no chess player in the database. Try adding one");
        }
        return ChessPlayerConverter.convertChessPlayerEntityListToDto(chessPlayerList);
    }

    @PostMapping
    ResponseEntity<?> addChessPlayer(@Valid @RequestBody ChessPlayerPayloadDTO chessPlayerPayloadDTO) {
        ChessPlayer existingPlayer = chessPlayerService.getChessPlayerById(chessPlayerPayloadDTO.getPin());
        if (existingPlayer != null) {
            // Player already exists in the database
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDetails("Pin already taken", HttpStatus.CONFLICT.value()));
        } else if (chessPlayerService.getChessPlayerByEmail(chessPlayerPayloadDTO.getEmail()) != null) {
            // Player email already exists in the database
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDetails("Email already taken", HttpStatus.CONFLICT.value()));
        }
        this.chessPlayerService.saveChessPlayer(ChessPlayerConverter.convertChessPlayerPayloadDtoToEntity(chessPlayerPayloadDTO));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable Long id) {
        ChessPlayer chessPlayer = this.chessPlayerService.getChessPlayerById(id);
        if (chessPlayer == null) {
            throw new NoResultException("Chess player not found");
        }
        this.chessPlayerService.deleteItemById(id);
    }

    @GetMapping("/{id}")
    ChessPlayerDTO getItemById(@PathVariable Long id) {
        ChessPlayer chessPlayer = this.chessPlayerService.getChessPlayerById(id);
        if (chessPlayer == null) {
            throw new NoResultException("Chess player not found");
        }
        return ChessPlayerConverter.convertChessPlayerEntityToDto(chessPlayer);
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> editChessPlayerById(@PathVariable Long id, @Valid @RequestBody ChessPlayerEditDTO chessPlayerEditDTO) {
        ChessPlayer existingPlayer = this.chessPlayerService.getChessPlayerById(id);
        if (existingPlayer == null) {
            throw new NoResultException("Chess player not found");
        }
        this.chessPlayerService.editItemById(existingPlayer, ChessPlayerConverter.convertChessPlayerEditDtoToEntity(chessPlayerEditDTO));
        return ResponseEntity.ok().build();
    }
}
