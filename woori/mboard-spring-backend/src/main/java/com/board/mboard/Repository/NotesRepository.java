package com.board.mboard.Repository;

import com.board.mboard.Entity.Notes_tbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes_tbl, Long> {
}
