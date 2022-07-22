package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본생성자 자동 추가
@Entity //table과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id //해당 table의 PK값
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙
    private Long id;

    @Column(length = 500,nullable= false) //table의 칼럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //굳이 @Column 선언하지않아도 해당클래스의 필드는 모두 칼럼
    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author =author;
    }

    public void update(String title, String content) {
        this.title= title;
        this.content = content;
    }
}
