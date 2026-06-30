import {client} from "./client.ts";
import type {Entry} from "../LibraryPage.tsx";

export const getEntries = async () : Promise<Entry[]> => {
    const response = await client.get("")
    return response.data
}