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
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/player")
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
        this.chessPlayerService.saveChessPlayer(ChessPlayerConverter.convertChessPlayerPayloadDtoToEntity(chessPlayerPayloadDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteItem(@PathVariable Long id) {
        ChessPlayer chessPlayer = this.chessPlayerService.getChessPlayerById(id);
        if (chessPlayer == null) {
            throw new NoResultException("Chess player not found");
        }
        this.chessPlayerService.deleteItemById(id);
        return ResponseEntity.noContent().build();
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
        return ResponseEntity.noContent().build();
    }
}
