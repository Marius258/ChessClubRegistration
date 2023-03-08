package com.marius.lt.ChessClubRegistration.controllers;

import com.marius.lt.ChessClubRegistration.converters.ChessPlayerConverter;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerDTO;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerPayloadDTO;
import com.marius.lt.ChessClubRegistration.services.ChessPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ChessPlayerConverter.convertChessPlayerEntityListToDto(this.chessPlayerService.getAllChessPlayers());
    }

    @PostMapping
    void addChessPlayer(@RequestBody ChessPlayerPayloadDTO chessPlayerPayloadDTO){
        this.chessPlayerService.saveChessPlayer(ChessPlayerConverter.convertChessPlayerPayloadDtoToEntity(chessPlayerPayloadDTO));
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable Long id) {
        this.chessPlayerService.deleteItemById(id);
    }

    @GetMapping("/{id}")
    ChessPlayerDTO getItemById(@PathVariable Long id) {
        return ChessPlayerConverter.convertChessPlayerEntityToDto(this.chessPlayerService.getChessPlayerById(id));
    }

    @PatchMapping("/{id}")
    void patchChessPlayerById(@PathVariable Long id, @RequestBody ChessPlayerPayloadDTO chessPlayerPayloadDTO) {
        this.chessPlayerService.editItemById(id, ChessPlayerConverter.convertChessPlayerPayloadDtoToEntity(chessPlayerPayloadDTO));
    }
}
