import {client} from "./client.ts";
import type {Entry} from "../LibraryPage.tsx";

// Fetching list of entries
export const getEntries = async () : Promise<Entry[]> => {
    const response = await client.get("")
    return response.data
}

// Creating a new entry
type CreateEntryRequest = {
    title: string;
    content: string;
}

export const createEntry = async (content: string) : Promise<Entry> => {
    const request: CreateEntryRequest = {title: "", content: content}
    const response = await client.post("", request)
    return response.data
}