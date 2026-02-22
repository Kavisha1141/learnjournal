Overall Architecture:
Client JSON → [RelationshipRequest DTO] → Controller → Service → Repository → DB

DB → Repository → Service → Controller → [RelationshipResponse DTO] → Client JSON



Design decisions:

- Used @ManyToOne annotation in Relationship for target and source fields because each relationship can be mapped to only one unique target and source ids. However, many relationships can have the same target and/or same source id. 
- Used Enum Type as String because using ordinal would break the system if I later decided to add a new relationship type in the enums
- Used RelationshipResponse and RelationshipRequest as DTO (Data Transfer Objects) to avoid exposing the db to the user