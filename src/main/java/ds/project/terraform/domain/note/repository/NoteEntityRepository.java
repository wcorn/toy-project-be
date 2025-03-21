package ds.project.terraform.domain.note.repository;

import ds.project.terraform.domain.note.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteEntityRepository extends JpaRepository<NoteEntity, Long> {

}
