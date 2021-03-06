package me.aurous.player.scenes;

import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import me.aurous.ui.UISession;
import me.aurous.ui.panels.ControlPanel;
import me.aurous.ui.widgets.ExceptionWidget;
import me.aurous.utils.Utils;
import me.aurous.utils.media.MediaUtils;

public class MediaPlayerScene {
	public ChangeListener<Duration> progressChangeListener;

	private Media media;

	public MediaPlayer player;

	public MediaView view;

	/**
	 * Create a JFX media player scene.
	 */
	public Scene createMediaPlayer(final String sourceURL) throws Throwable {
		final ControlPanel panel = UISession.getControlPanel();
		final Group root = new Group();
		root.autosize();
		MediaUtils.activeMedia = sourceURL;
		final String trailer = MediaUtils.getMediaURL(sourceURL);
		try {
			media = new Media(trailer.trim());

		} catch (final Exception e) {
			final ExceptionWidget eWidget = new ExceptionWidget(
					Utils.getStackTraceString(e, ""));
			eWidget.setVisible(true);
			return null;
		}

		player = new MediaPlayer(media);

		view = new MediaView(player);
		view.setFitWidth(1);
		view.setFitHeight(1);
		view.setPreserveRatio(false);

		// System.out.println("media.width: "+media.getWidth());

		final Scene mediaPlayer = new Scene(root, 1, 1, Color.BLACK);

		// player.play();

		player.setOnReady(() -> {
			player.setAutoPlay(false);
			panel.seek().setValue(0);
			if (sourceURL
					.contains("https://www.youtube.com/watch?v=kGubD7KG9FQ")) {
				player.pause();
			} else {
				player.play();
			}

		});

		progressChangeListener = (observableValue, oldValue, newValue) -> {

			final long currentTime = (long) newValue.toMillis();

			final long totalDuration = (long) player.getMedia().getDuration()
					.toMillis();
			updateTime(currentTime, totalDuration);
		};

		player.currentTimeProperty().addListener(progressChangeListener);

		player.setOnEndOfMedia(() -> {
			player.currentTimeProperty().removeListener(progressChangeListener);
			MediaUtils.handleEndOfStream();

		});

		UISession.setMediaPlayer(player);
		UISession.setMediaView(view);
		UISession.setMedia(media);

		return (mediaPlayer);
	}

	private void updateTime(final long currentTime, final long totalDuration) {
		final ControlPanel panel = UISession.getControlPanel();
		final int percentage = (int) (((currentTime * 100.0) / totalDuration) + 0.5); // jesus
		final double seconds = currentTime / 1000.0;
		UISession.getControlPanel().seek().setValue(percentage);
		panel.seek().setValue(percentage);
		panel.current().setText(MediaUtils.calculateTime((int) seconds));

	}

}
