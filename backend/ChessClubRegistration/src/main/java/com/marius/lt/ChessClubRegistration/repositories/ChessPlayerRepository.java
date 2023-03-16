package com.marius.lt.ChessClubRegistration.repositories;

import com.marius.lt.ChessClubRegistration.entities.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessPlayerRepository extends JpaRepository<ChessPlayer, Long> {

    ChessPlayer findByEmail(String email);
    ChessPlayer findByPin(Long pin);
}
