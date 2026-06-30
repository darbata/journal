import type {Entry} from "./LibraryPage.tsx";

type EchoesProps = {
    echoes: Entry[]
}

export default function Echoes({echoes}: EchoesProps) {

    return (
        <div className="border-l p-8">
            <span className="font-sans font-semibold text-fg-faint tracking-wider text-lg">ECHOES</span>


        </div>
    )
}