package fr.entities

enum class MoveResult {
    MOVED_TO_NEXT_ROOM,
    MOVED_WITHIN_ROOM,
    END_OF_DUNGEON,
    CHANGED_DIRECTION,
    END_OF_GAME,
    INFO_DISPLAYED,
    NOT_ALLOWED
}
