package models.pet;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Pet{
	private List<String> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}