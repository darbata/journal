import {useState} from "react";
import {NotebookPen} from "lucide-react";

const placeholders = [
    "What's on your mind?"
]

type WritingPageProps = {
    today: Date
}

export default function WritingPage({today} : WritingPageProps) {

    const [content, setContent] = useState("");

    const [placeholder, setPlaceholder] = useState(
        () => placeholders[Math.floor(Math.random() * placeholders.length)]
    );

    return (
        <div className="flex flex-col gap-16 w-full h-full">
            <div
                className="font-sans text-fg-muted text-xl tracking-widest"
            >
                {`${today.toLocaleString('default', {weekday: 'long'}).toLocaleUpperCase()}`} &middot; {`${today.toLocaleString('default', {month: 'long'}).toLocaleUpperCase()} ${today.getDate()}`}
            </div>

            <textarea
                className="border-none focus:outline-none font-serif text-4xl w-full h-full overflow-y-scroll resize-none text-primary 2xl:max-w-3/4 pr-2 caret-primary"
                placeholder={placeholder}
                value={content}
                onChange={(e) => setContent(e.target.value)}
            />

            <button className="absolute bottom-32 right-16 xs:right-32 lg:right-48 2xl:right-64 rounded-full bg-accent text-surface drop-shadow-2xl p-6">
                <NotebookPen size="28" className="shrink-0"/>
            </button>
        </div>
    )


}