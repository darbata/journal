import type {Emotion, Entry} from "./LibraryPage.tsx";
import {ChevronLeft} from "lucide-react";
import {colourMap} from "./ColourMap.tsx";

const dto: Entry = {
    "id": "b82e616f-520e-4189-9ec9-3a756162a51a",
    "authorId": "daz",
    "title": "Title",
    "content": "Couldn't settle all evening. Kept refreshing things that didn't matter, then felt worse for it. I think I was avoiding the email I still haven't answered. Writing it down at least gets it out of the loop in my head.",
    "dominant": "fear",
    "scores": {
        "anger": 0.015340846908061612,
        "disgust": 0.029825996446426733,
        "fear": 0.6462930912188467,
        "joy": 0.037084655885154194,
        "neutral": 0.21755711133220465,
        "sadness": 0.011651580224444976,
        "surprise": 0.04224671798486117
    },
    "analysed": true,
    "createdAt": "2026-06-18T16:25:13.957492Z",
    "updatedAt": "2026-06-18T16:25:13.957492Z"
}

type EntryPageProps = {
    close: () => null
    entry: Entry
}

export default function EntryPage({close, entry} : EntryPageProps) {

    const d = new Date(entry.createdAt);

    return (
        <div className="flex">

            <div className="p-8">
                <div className="flex items-center gap-8 text-fg-muted mb-8">
                    <ChevronLeft size="28" className="cursor-pointer" onClick={() => close()}/>
                    <span className="font-sans text-xl tracking-widest">
                    {`${d.toLocaleString("default", {weekday: 'long'}).toLocaleUpperCase()}`} &middot; {`${d.toLocaleString("default", {month: 'long'}).toLocaleUpperCase()} ${d.getDate() }`} &middot; {`${d.toLocaleTimeString("default", {hour: "2-digit", minute: "2-digit", hourCycle: "h24"})}`}
                </span>
                </div>
                <p className="text-fg font-serif text-4xl mb-8 leading-16">{entry.content}</p>
                <div className="flex flex-col gap-2">
                    <span className="font-sans text-fg-muted text-md tracking-widest">FELT LIKE</span>
                    <span className={`${colourMap[entry.dominant]} px-4 text-lg`}>{entry.dominant}</span>
                </div>
            </div>

            {/*
                For when Echoes is implemented (vector store +
                <div className="border-l p-8">
                    <span className="font-sans font-semibold text-fg-faint tracking-wider text-lg">ECHOES</span>
                </div>
            */}


        </div>

    )
}