import DailyOverview from "./DailyOverview.tsx";
import {useState} from "react";
import EntryPage from "./EntryPage.tsx";
import {useEntries} from "./hooks/useEntries.ts";

export type Emotion =
    | "anger"
    | "disgust"
    | "fear"
    | "joy"
    | "neutral"
    | "sadness"
    | "surprise";

export interface BaseEntry {
    id: string;
    authorId: string;
    title: string;
    content: string;
    createdAt: string;
    updatedAt: string;
}

export type Entry =
    | (BaseEntry & {
        analysed: true;
        dominant: Emotion;
        scores: Record<Emotion, number>;
    })
    | (BaseEntry & {
        analysed: false;
        dominant: "none";
        scores: Record<string, never>;
    });

export default function LibraryPage() {

    const dto = useEntries()
    const [openEntry, setOpenEntry] = useState<Entry | null>(null);
    const days = new Map<string, Entry[]>();
    const entries = new Map<string, Entry>();

    if (dto != null) {
        dto.forEach((entry) => {
            const key = dayKey(entry.createdAt);
            if (!days.has(key)) days.set(key, []);
            days.get(key)!.push(entry);

            entries.set(entry.id, entry);
        });
    }

    if (openEntry !== null) {
        return (
            <EntryPage close={() => setOpenEntry(null)} entry={openEntry} />
        )
    }

    return (
        <div className={`flex flex-col gap-12 h-full`}>
            <span className="text-4xl text-fg font-serif font-semibold">Journal</span>
            <div className="flex-1 min-h-0 overflow-y-auto pr-4">
                {[...days].map(([key, entries]) => (
                    <DailyOverview key={key} date={new Date(key)} entries={entries} setOpenEntry={setOpenEntry} />
                ))}
            </div>
        </div>
    );
}

function dayKey(instant: string): string {
    const d = new Date(instant);
    return `${d.getFullYear()}-${d.getMonth()}-${d.getDate()}`;
}