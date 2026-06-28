import {type LucideIcon} from "lucide-react";

export type SidebarMenuItemProps = {
    icon: LucideIcon;
    label: string;
    selected: boolean;
    onClick: () => void;
}

export default function SidebarMenuItem({icon: Icon, label, selected, onClick} : SidebarMenuItemProps) {

    return (
        <div
            className={`
                flex gap-8 items-center w-full px-4 py-4 rounded-2xl text-fg-muted 
                transition duration-500
                ${selected ? "bg-surface text-primary drop-shadow-xl" : ""}
                
            `}
            onClick={onClick}
        >
            {<Icon className="shrink-0" />}
            <p className="text-2xl font-medium">{label}</p>
        </div>
    )

}