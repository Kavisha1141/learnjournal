package com.kavisha.learnjournal.model;


public class RelationshipResponse {
    private Long id;        
    private Long sourceId;
    private Long targetId;
    private RelationshipType type;

    public RelationshipResponse(Long id, Long source_id, Long target_id, RelationshipType type) {
        this.id = id;
        this.sourceId = source_id;
        this.targetId = target_id;
        this.type = type;
    }

    public static RelationshipResponse fromEntity(Relationship r) {
        return new RelationshipResponse(
            r.getId(),
            r.getSource().getId(),
            r.getTarget().getId(),
            r.getType()
        );
    }
}
