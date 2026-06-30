import {useEffect, useState} from "react";
import type {Entry} from "../LibraryPage.tsx";
import {getEntries} from "../api/methods.ts";

export const useEntries = () => {
    const [entries, setEntries] = useState<Entry[]>()

    useEffect( () => {
        const fetchEntries = async () => {
            const entries: Entry[] = await getEntries();
            setEntries(entries)
        }
        fetchEntries()
    }, [])

    return entries;
}