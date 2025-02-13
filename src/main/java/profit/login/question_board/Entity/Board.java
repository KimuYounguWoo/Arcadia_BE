package profit.login.question_board.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.bson.types.ObjectId;
import profit.login.entity.User;
import profit.login.question_board.dto.BoardDto;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name="board")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column
    private String documentId;

    private String title;   // 제목
    private String body;    // 본문

    @Builder.Default
    private int viewCount = 0; // 조회수 필드 추가

    @Enumerated(EnumType.STRING)
    private BoardCategory category; // 카테고리

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;      // 작성자

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Transient
    private String userName;

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Like> likes;       // 좋아요
    private Integer likeCnt;        // 좋아요 수

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Comment> comments; // 댓글
    private Integer commentCnt;     // 댓글 수


    @Builder.Default
    @Column
    private Integer point = 0; //채택 포인트, 카테고리 구분없이 board 엔티티는 통일되다보니 기본값은 0으로 설정

    public void update(BoardDto dto) {
        this.title = dto.getTitle();
        this.body = dto.getBody();
    }

    public void incrementViewCount() {
        this.viewCount++;
    }


    public void likeChange(Integer likeCnt) {
        this.likeCnt = likeCnt;
    }

    public void commentChange(Integer commentCnt) {
        this.commentCnt = commentCnt;
    }


    @PostLoad
    private void postLoad() {
        this.userName = user != null ? user.getFullName() : null;
    }

}