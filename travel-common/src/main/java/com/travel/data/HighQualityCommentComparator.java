package com.travel.data;

import java.util.Comparator;

import com.travel.entity.comment.HighQualityComment;

public class HighQualityCommentComparator implements
		Comparator<HighQualityComment> {

	@Override
	public int compare(HighQualityComment o1, HighQualityComment o2) {
		if (o2.getRankScore() > o1.getRankScore())
			return 1;
		if (o2.getRankScore() < o1.getRankScore())
			return -1;
		return 0;
	}

}
