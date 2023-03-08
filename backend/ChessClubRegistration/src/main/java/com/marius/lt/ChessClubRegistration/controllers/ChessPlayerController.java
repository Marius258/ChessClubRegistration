package com.marius.lt.ChessClubRegistration.controllers;

import com.marius.lt.ChessClubRegistration.converters.ChessPlayerConverter;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerDTO;
import com.marius.lt.ChessClubRegistration.services.ChessPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
