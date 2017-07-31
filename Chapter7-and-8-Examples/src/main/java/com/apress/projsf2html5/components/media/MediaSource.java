package com.apress.projsf2html5.components.media;

import java.util.Objects;

/**
 * {@linkplain MediaSource Media source} used to provide the
 * {@link UIMediaComponent} with alternative media files.
 */
public class MediaSource {

    private String source;
    private String type;

    /**
     * Creates a new instance of {@link MediaSource} with a blank source and
     * mime type.
     */
    public MediaSource() {
        this("", "");
    }

    /**
     * Creates a new instance of {@link MediaSource} with a preset source and
     * MIME type.
     *
     * @param source URL of the media file to play
     * @param type MIME type of the media file
     */
    public MediaSource(String source, String type) {
        this.source = source;
        this.type = type;
    }

    /**
     * Gets the URL of the media file to play.
     *
     * @return URL of the media file to play
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the URL of the media file to play.
     *
     * @param source URL of the media file to play
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the MIME type of the media file specified as the source.
     *
     * @return MIME type of the media file specified as the source
     * @see <a href="http://www.iana.org/assignments/media-types/">IANA MIME
     * types</a>
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the MIME type of the media file specified as the source.
     *
     * @param type MIME type of the media file specified as the source
     * @see <a href="http://www.iana.org/assignments/media-types/">IANA MIME
     * types</a>
     */
    public void setType(String type) {
        this.type = type;
    }
}
