package com.example.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVo {
	private int no;
	private int roomNo;
	private int rateLoc;
	private int rateClean;
	private int rateComu;
	private int rateChip;
	private String visitDate;
	private String recommendPlace;
	private String notRecommendPerson;

	public ReviewVo(int roomNo, int rateLoc, int rateClean, int rateComu, int rateChip, String visitDate, String recommendPlace, String notRecommendPerson) {
		this.roomNo = roomNo;
		this.rateLoc = rateLoc;
		this.rateClean = rateClean;
		this.rateComu = rateComu;
		this.rateChip = rateChip;
		this.visitDate = visitDate;
		this.recommendPlace = recommendPlace;
		this.notRecommendPerson = notRecommendPerson;
	}
}
