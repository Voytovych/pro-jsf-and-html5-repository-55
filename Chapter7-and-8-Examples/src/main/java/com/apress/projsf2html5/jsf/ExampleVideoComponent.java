package com.apress.projsf2html5.jsf;

import com.apress.projsf2html5.components.media.MediaSource;
import com.apress.projsf2html5.components.media.MediaTrack;
import com.apress.projsf2html5.components.media.MediaTrackKind;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "exampleVideoComponent")
@RequestScoped
public class ExampleVideoComponent {


    public Collection<MediaSource> getMediaSources() {
        Collection<MediaSource> sources = new ArrayList<>();
        sources.add(new MediaSource("media/trailer.mp4", "video/mp4"));
        sources.add(new MediaSource("media/trailer.webm", "video/webm"));
        return sources;
    }

     public Collection<MediaTrack> getTextTracks() {
        Collection<MediaTrack> tracks = new ArrayList<>();
        tracks.add(new MediaTrack("media/subtitles_da.vtt", MediaTrackKind.subtitles, "Dansk", new Locale("da"), false));
        tracks.add(new MediaTrack("media/subtitles_en.vtt", MediaTrackKind.subtitles, "English", Locale.ENGLISH, true));
        return tracks;
    }
}
