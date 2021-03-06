package me.aurous.ui;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import me.aurous.player.scenes.MediaPlayerScene;
import me.aurous.ui.frames.AurousFrame;
import me.aurous.ui.frames.VisualizerFrame;
import me.aurous.ui.panels.ControlPanel;
import me.aurous.ui.widgets.AboutWidget;
import me.aurous.ui.widgets.BuilderWidget;
import me.aurous.ui.widgets.ImporterWidget;
import me.aurous.ui.widgets.SearchWidget;
import me.aurous.ui.widgets.SettingsWidget;

/**
 * Created by Andrew on 9/4/2014.
 */
public class UISession {

	public static AboutWidget getAboutWidget() {
		return aboutWidget;
	}

	public static BuilderWidget getBuilderWidget() {
		return builderWidget;
	}

	public static ControlPanel getControlPanel() {
		return controlPanel;
	}

	public static ImporterWidget getImporterWidget() {
		return importerWidget;
	}

	public static JFXPanel getJFXPanel() {
		return jfxPanel;
	}

	public static Media getMedia() {
		return media;
	}

	public static MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public static MediaPlayerScene getMediaPlayerScene() {
		return mediaScene;
	}

	public static MediaView getMediaView() {
		return mediaView;
	}

	public static AurousFrame getPresenter() {
		return presenter;
	}

	public static SearchWidget getSearchWidget() {
		return searchWidget;
	}

	public static SettingsWidget getSettingsWidget() {
		return settingsWidget;
	}

	public static VisualizerFrame getVisualFrame() {
		return visualFrame;
	}

	public static void setAboutWidget(final AboutWidget aboutWidget) {
		UISession.aboutWidget = aboutWidget;
	}

	public static void setBuilderWidget(final BuilderWidget builderWidget) {
		UISession.builderWidget = builderWidget;
	}

	public static void setControlPanel(final ControlPanel controlPanel) {
		UISession.controlPanel = controlPanel;
	}

	public static void setImporterWidget(final ImporterWidget importerWidget) {
		UISession.importerWidget = importerWidget;
	}

	public static void setJFXPanel(final JFXPanel fxPanel) {
		UISession.jfxPanel = fxPanel;

	}

	public static void setMedia(final Media media) {
		UISession.media = media;

	}

	public static void setMediaPlayer(final MediaPlayer mediaPlayer) {
		UISession.mediaPlayer = mediaPlayer;
	}

	public static void setMediaPlayerScene(final MediaPlayerScene scene) {
		UISession.mediaScene = scene;

	}

	public static void setMediaView(final MediaView mediaView) {
		UISession.mediaView = mediaView;
	}

	public static void setPresenter(final AurousFrame presenter) {
		UISession.presenter = presenter;
	}

	public static void setSearchWidget(final SearchWidget searchWidget) {
		UISession.searchWidget = searchWidget;
	}

	public static void setSettingsWidget(final SettingsWidget settingsWidget) {
		UISession.settingsWidget = settingsWidget;
	}

	public static void setVisualFrame(final VisualizerFrame visualFrame) {
		UISession.visualFrame = visualFrame;
	}

	private static AurousFrame presenter;

	private static ControlPanel controlPanel;

	private static SearchWidget searchWidget;

	private static AboutWidget aboutWidget;

	private static SettingsWidget settingsWidget;

	private static BuilderWidget builderWidget;

	private static ImporterWidget importerWidget;

	private static MediaPlayer mediaPlayer;

	private static MediaView mediaView;

	private static Media media;

	private static MediaPlayerScene mediaScene;
	private static VisualizerFrame visualFrame;

	private static JFXPanel jfxPanel;
}
