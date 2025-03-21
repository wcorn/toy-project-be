package ds.project.terraform.service;

import ds.project.terraform.api.dto.GetNoteDto;
import ds.project.terraform.api.dto.PostNoteDto;
import ds.project.terraform.domain.note.entity.NoteEntity;
import ds.project.terraform.domain.note.repository.NoteEntityRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiService {
    private final NoteEntityRepository noteEntityRepository;

    @Transactional
    public void postNote(PostNoteDto dto) {
        NoteEntity noteEntity = NoteEntity.of(dto.getText());
        noteEntityRepository.save(noteEntity);
    }

    public List<GetNoteDto> getNote() {
        return noteEntityRepository.findAll().stream().map((note)->GetNoteDto.of(note.getText())).collect(Collectors.toList());
    }
}
