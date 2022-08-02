package mrvu.interfaces;

import java.util.List;

import mrvu.dto.SizeDto;
import mrvu.jpa.Size;

public interface SizeService {

	List<Size> list();

	String add(SizeDto dto);

	String update(SizeDto dto);

	String delete();

}
