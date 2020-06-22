package domain.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameCountFactory {

	private static final List<GameCount> gameCounts = IntStream.range(2, 11)
		.mapToObj(GameCount::new)
		.collect(Collectors.toList());

	private GameCountFactory() {

	}

	public static GameCount of(final String gameCountInput) {
		return gameCounts.stream()
			.filter(gameCount -> gameCount.getGameCount() == Integer.parseInt(gameCountInput))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("게임 횟수는 2 ~ 10만 가능합니다. gameCount = " + gameCountInput));
	}
}
