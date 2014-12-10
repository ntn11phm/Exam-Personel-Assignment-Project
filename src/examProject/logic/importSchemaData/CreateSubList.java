package examProject.logic.importSchemaData;

import java.util.ArrayList;
import java.util.List;

import examProject.transferObjects.ExamOccationTO;

public class CreateSubList {
	
	public List<ExamOccationTO> extractSubList(String bookingId, List<ExamOccationTO> currentList) {
		List<ExamOccationTO> arrResult = new ArrayList<ExamOccationTO>();
		for (int i = 0; i < currentList.size(); i++)
			if (currentList.get(i).getBookingId().equals(bookingId))
				arrResult.add(currentList.get(i));
		
		return arrResult;
	}
}
