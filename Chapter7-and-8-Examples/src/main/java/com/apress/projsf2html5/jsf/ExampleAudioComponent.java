package com.apress.projsf2html5.jsf;

import com.apress.projsf2html5.components.media.MediaSource;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "exampleAudioComponent")
@RequestScoped
public class ExampleAudioComponent {

    public Collection<MediaSource> getMediaSources() {
        Collection<MediaSource> sources = new ArrayList<>();
        sources.add(new MediaSource("media/04-Death_Becomes_Fur.mp4", "audio/mp4"));
        sources.add(new MediaSource("media/04-Death_Becomes_Fur.oga", "audio/ogg; codecs=vorbis"));
        return sources;
    }
}
