import type {Entry} from "./LibraryPage.tsx";
import {colourMap} from "./ColourMap.tsx";

type EntryOverviewProps = {
    last: boolean
    entry: Entry
    onClick: () => void
}

export function EntryOverview({onClick, last, entry} : EntryOverviewProps) {

    const time = new Date(entry.createdAt).toLocaleTimeString(
        "en-AU",
        {hour: "2-digit", minute: "2-digit", hourCycle: "h24"}
    );

    const colour = colourMap[entry.dominant] ?? "bg-none";

    return (
        <div onClick={() => onClick()} className={`flex justify-between font-serif text-primary items-center gap-8 py-4 px-8 ${last ? "" : "border-b"}  border-b-fg-muted`}>
            <span className="shrink-0 font-sans text-lg">{time}</span>
            <div className="w-full text-xl line-clamp-1 px-4">
                <p>{entry.content}</p>
            </div>
            <span className={`rounded-full w-3 h-3 ${colour} shrink-0`}></span>
        </div>
    )
}

type DailyOverviewProps = {
    date: Date
    entries: Entry[]
    setOpenEntry: () => void
}

export default function DailyOverview({date, entries, setOpenEntry} : DailyOverviewProps) {

    const d = new Date(date);
    const today = new Date(date) == d;

    return (
        <div className="flex flex-col w-full bg-surface font-serif rounded-2xl overflow-hidden mb-8">
            <div className="flex items-center justify-between border-b border-b-fg-muted py-4 px-8">
                <span className="text-3xl font-semibold">{` ${today ? "Today - " : ""} ${d.toLocaleString('default', {month: 'long'})} ${d.getDate()}`}</span>
                <span className="text-fg-muted pr-[0.2rem]">{entries.length}</span>
            </div>
            <li className="list-none">
                {entries.map((e, index) => <EntryOverview onClick={() => setOpenEntry(e)} last={index == entries.length - 1} entry={e}/>)}
            </li>
        </div>
    )
}