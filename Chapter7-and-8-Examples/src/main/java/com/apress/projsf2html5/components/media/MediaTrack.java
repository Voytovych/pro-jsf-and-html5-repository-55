package com.apress.projsf2html5.components.media;

import java.util.Locale;

/**
 * {@linkplain MediaTrack Text track } used to provide the
 * {@link UIMediaComponent} with localized text tracks for captioning, metadata,
 * subtitles, etc.
 */
public class MediaTrack {

    private String source;
    private MediaTrackKind kind;
    private boolean defaultTrack;
    private String label;
    private Locale locale;

    /**
     * Creates a new instance of {@link MediaTrack} with no details set.
     */
    public MediaTrack() {
        this("", null);
    }

    /**
     * Creates a new instance of {@link MediaTrack} with the track and kind
     * preset.
     *
     * @param source URL to the VTT text track
     * @param kind Kind of text track
     */
    public MediaTrack(String source, MediaTrackKind kind) {
        this(source, kind, "", null, false);
    }

    /**
     * Creates a new instance of {@link MediaTrack} with the track, kind, and
     * label preset.
     *
     * @param source URL to the VTT text track
     * @param kind Kind of text track
     * @param label Label of the track (for display)
     */
    public MediaTrack(String source, MediaTrackKind kind, String label) {
        this(source, kind, label, null, false);
    }

    /**
     * Creates a new instance of {@link MediaTrack} with the track, kind, and
     * label preset.
     *
     * @param source URL to the VTT text track
     * @param kind Kind of text track
     * @param label Label of the track (for display)
     * @param locale Locale of the VTT text track
     */
    public MediaTrack(String source, MediaTrackKind kind, String label, Locale locale) {
        this(source, kind, label, locale, false);
    }

    /**
     * Creates a new instance of {@link MediaTrack} with the source, kind,
     * label, {@link Locale} and default track preset.
     *
     * @param source URL to the VTT text track
     * @param kind Kind of text track
     * @param label Label of the track (for display)
     * @param locale Locale of the VTT text track
     * @param defaultTrack Is the track the default track?
     */
    public MediaTrack(String source, MediaTrackKind kind, String label, Locale locale, boolean defaultTrack) {
        this.source = source;
        this.kind = kind;
        this.defaultTrack = defaultTrack;
        this.label = label;
        this.locale = locale;
    }

    /**
     * Determine if the {@link MediaTrack} is the default track to use if the
     * browser could not match the appropriate track based on the
     * {@link Locale}.
     *
     * @return {@link Boolean#TRUE} if this is the default track, otherwise
     * {@link Boolean#FALSE}
     */
    public boolean isDefaultTrack() {
        return defaultTrack;
    }

    /**
     * Sets the Default Track indicator of text track.
     *
     * @param defaultTrack {@link Boolean#TRUE} if this is the default track,
     * otherwise {@link Boolean#FALSE}
     */
    public void setDefaultTrack(boolean defaultTrack) {
        this.defaultTrack = defaultTrack;
    }

    /**
     * Gets the URL of the VTT text track.
     *
     * @return URL of the VTT text track
     * @see <a href="http://dev.w3.org/html5/webvtt/">WebVTT: The Web Video Text
     * Tracks Format</a>
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the URL of the VTT text track.
     *
     * @param source URL of the VTT text track
     * @see <a href="http://dev.w3.org/html5/webvtt/">WebVTT: The Web Video Text
     * Tracks Format</a>
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the kind of text track.
     *
     * @return Kind of text track
     */
    public MediaTrackKind getKind() {
        return kind;
    }

    /**
     * Sets the kind of text track.
     *
     * @param kind Kind of text track
     */
    public void setKind(MediaTrackKind kind) {
        this.kind = kind;
    }

    /**
     * Gets the label of the text track for display.
     *
     * @return Label of the text track for display.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label of the text track for display.
     *
     * @param label Label of the text track for display
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the {@link Locale} of the text track.
     *
     * @return {@link Locale} of the text track
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Sets the {@link Locale} of the text track.
     *
     * @param locale {@link Locale} of the text track
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
