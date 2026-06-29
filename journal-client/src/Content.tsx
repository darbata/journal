import WritingPage from "./WritingPage.tsx";
import LibraryPage from "./LibraryPage.tsx";

type ContentProps = {
    active: string
}

export default function Content({active} : ContentProps) {
    switch (active) {
        case "Write":
            return <WritingPage today={new Date()}/>
        case "Library":
            return <LibraryPage />
        default:
            return <div>default</div>
    }
}