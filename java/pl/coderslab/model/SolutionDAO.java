package pl.coderslab.model;

import java.sql.*;
import java.util.*;

public class SolutionDAO {
    private static final String CREATE_SOLUTION_QUERY =
            "INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
    private static final String READ_SOLUTION_QUERY = "SELECT * FROM solution WHERE id = ?";
    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET created=?, updated=?, description=?, exercise_id=?, users_id=? WHERE id=?";
    private static final String DELETE_SOLUTION_QUERY = "DELETE FROM solution WHERE id=?";
    private static final String FIND_ALL_SOLUTION_QUERY = "SELECT * FROM solution";
    private static final String FIND_ALL_BY_USER_ID_QUERY = "SELECT * FROM solution WHERE users_id=?";
    private static final String FIND_ALL_BY_EXERCISE_ID_QUERY = "SELECT * FROM solution WHERE exercise_id=?";
    private static final String FIND_RECENT_QUERY = "SELECT e.title, u.username, s.created, s.id FROM solution s\n" +
            "    JOIN exercise e \n" +
            "    ON s.exercise_id = e.id\n" +
            "JOIN users u on s.users_id = u.id ORDER BY created LIMIT ?";
    private  static final String USER_SOLUTION_DETAILS_QUERY = "SELECT e.title, s.created, s.id FROM solution s\n" +
            "JOIN exercise e ON s.exercise_id = e.id\n" +
            "WHERE s.users_id = ?";

    public Solution create(Solution solution) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);

            //Ustawienie parametrów zapytania (wartości do wstawienia)
            statement.setTimestamp(1, solution.getCreated());
            statement.setTimestamp(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUsers_id());

            //Wykonanie zapytania
            statement.executeUpdate();

            // Pobranie zestawu wygenerowanych kluczy
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.first()) {
                int generatedKey = generatedKeys.getInt(1);
                solution.setId(generatedKey);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return solution;
    }

    public Solution read(int id) {

        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUsers_id(resultSet.getInt("users_id"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Solution solution) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setTimestamp(1, solution.getCreated());
            statement.setTimestamp(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUsers_id());
            statement.setInt(6, solution.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Solution[] findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            Solution[] solutions = new Solution[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTION_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise id"));
                solution.setUsers_id(resultSet.getInt("users id"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }


    private Solution[] addToArray(Solution u, Solution[] solutions) {
        Solution[] tmpSolutions = Arrays.copyOf(solutions, solutions.length + 1);
        tmpSolutions[solutions.length] = u;
        return tmpSolutions;
    }


    public Solution[] findAllByUserId(int users_id) {
        try (Connection conn = DbUtil.getConnection()) {
            Solution[] solutions = new Solution[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_USER_ID_QUERY);
            statement.setInt(1, users_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise id"));
                solution.setUsers_id(resultSet.getInt("users id"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Solution[] findAllByExerciseId(int exercise_id) {
        try (Connection conn = DbUtil.getConnection()) {
            Solution[] solutions = new Solution[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_EXERCISE_ID_QUERY);
            statement.setInt(1, exercise_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise id"));
                solution.setUsers_id(resultSet.getInt("users id"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[][] findRecent(int limit) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_RECENT_QUERY);
            statement.setInt(1, limit);
            ResultSet resultSet = statement.executeQuery();

            String[][] resultTab = new String[limit][4];
            int i = 0;
            while (resultSet.next()) {
                resultTab[i][0] = resultSet.getString("e.title");
                resultTab[i][1] = resultSet.getString("u.username");
                resultTab[i][2] = resultSet.getString("s.created");
                resultTab[i][3] = resultSet.getString("s.id");
                i++;
            }
            if (i < 5){
                resultTab=Arrays.copyOf(resultTab, i);
            }
            return resultTab;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Set<String[]> findSolutionsByUser(int user_id){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(USER_SOLUTION_DETAILS_QUERY);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();

           Set<String[]> result = new HashSet<>();
            while (resultSet.next()) {
                String[] singleSolution = new String[3];
                singleSolution[0]=resultSet.getString("e.title");
                singleSolution[1]=resultSet.getString("s.created");
                singleSolution[2]=resultSet.getString("s.id");
                result.add(singleSolution);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
