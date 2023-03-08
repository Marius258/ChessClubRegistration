package com.marius.lt.ChessClubRegistration.services;

import com.marius.lt.ChessClubRegistration.repositories.ChessPlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChessPlayerService {

    private final ChessPlayerRepository chessPlayerRepository;
}
