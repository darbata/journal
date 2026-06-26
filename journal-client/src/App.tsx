import SidebarMenuItem from "./SidebarMenuItem.tsx";
import {ChartNoAxesCombined, Library, PencilLine} from "lucide-react";
import {useState} from "react";
import WritingPage from "./WritingPage.tsx";

const menu = [
    {icon: PencilLine, label: "Write"},
    {icon: Library, label: "Library"},
    {icon: ChartNoAxesCombined, label: "Trends"}
]

export default function App() {

    const [active, setActive] = useState(menu[0].label);

    return (
        <div className="h-screen w-screen bg-bg flex text-fg">
            <div className="bg-sidebar w-1/5 p-16">
                <h2 className="font-serif font-semibold text-4xl mb-16">Margin</h2>
                {/* sidebar -> TODO: extract to own */}
                <div className="flex flex-col gap-2">
                    {
                        menu.map(
                            (item) => <SidebarMenuItem
                                icon={item.icon}
                                label={item.label}
                                selected={active == item.label}
                                onClick={() => setActive(item.label)}
                            />)
                    }
                </div>
            </div>

            <div className="py-32 px-64">
                <WritingPage today={new Date} />
            </div>



        </div>
    )
}