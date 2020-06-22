package domain.car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PositionFactory {
	private static final List<Position> positions = IntStream.range(0, 11)
		.mapToObj(Position::new)
		.collect(Collectors.toList());

	private PositionFactory() {

	}

	public static Position of(int positionValue) {
		return positions.stream()
			.filter(position -> position.getPosition() == positionValue)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("나올 수 없는 위치 입니다. position = " + positionValue));
	}
}
