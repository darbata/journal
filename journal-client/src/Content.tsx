import WritingPage from "./WritingPage.tsx";

type ContentProps = {
    active: string
}

export default function Content({active} : ContentProps) {
    switch (active) {
        case "Write":

            return <WritingPage today={new Date()}/>
        default:
            return <div>default</div>
    }
}