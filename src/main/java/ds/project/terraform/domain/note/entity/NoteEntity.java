package ds.project.terraform.domain.note.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "note")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long adminId;
    @Column(name = "text")
    private String text;

    @Builder
    private NoteEntity(String text) {
        this.text = text;
    }

    public static NoteEntity of(String text) {
        return new NoteEntity(text);
    }
}
