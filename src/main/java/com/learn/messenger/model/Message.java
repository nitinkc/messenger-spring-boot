package com.learn.messenger.model;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(min=2,message = "message should be atleast 5 characters long")
	private String message;
	@Past(message = "Message Cannot be in the Future/Past")
	@Column(name = "create_dt")
	private Date created;
	private String author;
}
